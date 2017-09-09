package practice14;

public class MutableString {
	private String value;

	/* MutableString Constructor(String val) */
	/** Initializes the value. */
	public MutableString(String val) {
		setValue(val);
	}

	/* Method: setValue(String value) */
	/** Changes its value to the value of the passed string. */
	public void setValue(String value) {
		this.value = value;
	}

	/* Method: getValue() */
	/** Returns the string value of this object. */
	public String getValue() {
		return toString();
	}

	/* replaceAll(String toReplace, String replaceWith) */
	/**
	 * Replaces each substring of this string that matches the given regular
	 * expression with the given replacement.
	 */
	public void replaceAll(String toReplace, String replaceWith) {
		/*
		 * This is a little bit tricky one, to understand it, you have to be
		 * familiar with the indexOf method of basic String class, if you're
		 * not, go learn about it and come back after!
		 */
		int index = 0;// we start of from index 0 and search for the occurence
						// of our substring
		while (true) {
			index = value.indexOf(toReplace, index);

			if (index == -1)// If we can't find any more of the strings we
							// wanted to replace there isn't anything to do
							// here anymore.
				break;
			setValue(value.substring(0, index) + replaceWith //
					+ value.substring(index + toReplace.length()));

			/*
			 * This is our "tricky" part. Instead of looking for toReplace
			 * string from the start of our string on each iteration (which
			 * would be slower and even would result in an endless loop in some
			 * cases (when toReplace is a substring of replaceWith)) we're gonna
			 * look for it after the end ouf processed part of our string.
			 * 
			 */
			index += replaceWith.length();
		}
	}

	/* Method: indexIsInRange(int i) */
	/** Returns if passed value is within bounds of this string. */
	private boolean indexIsInRange(int i) {
		return i >= 0 && i < value.length();
	}

	/* Method: (int start, int end) */
	/**
	 * Removes the characters from the specified beginIndex to the character at
	 * index endIndex-1. Thus the length of the removed substring is end-start.
	 */
	public void deleteSub(int start, int end) {
		if (indexIsInRange(start) && indexIsInRange(end)) {
			setValue(value.substring(0, start) + value.substring(end));
		}
	}

	/* Method: append(String b) */
	/**
	 * Concatenates the specified string to the end of this string.
	 */
	public void append(String b) {
		value += b;
	}

	/* Method: length() */
	/** Returns the length of this string. */
	public int length() {
		return value.length();
	}

	/* Method: toString() */
	/**
	 * Returns a string representation of the object.
	 */
	@Override
	public String toString() {

		return this.value;
	}
}

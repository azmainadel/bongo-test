
	    public static boolean areAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
		    return false;

		int xorValue = 0;

		for (int i = 0; i < str1.length(); i++) {
		    xorValue ^= (int) str1.charAt(i);
		    xorValue ^= (int) str2.charAt(i);
		}

		return (xorValue == 0);
	    }


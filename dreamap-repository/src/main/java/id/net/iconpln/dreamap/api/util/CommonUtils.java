package id.net.iconpln.dreamap.api.util;

import java.util.List;

public class CommonUtils {//NOPMD

	@SuppressWarnings("rawtypes")
	public static Boolean isNullOrEmpty(Object obj) {
		if (obj == null) {
			return true;
		} else {
			if (obj instanceof List) {
				if (((List) obj).isEmpty()) {
					return true;
				} else {
					if (obj.toString().trim().equals("")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static Boolean isNotNullOrEmpty(Object obj) {
		return !isNullOrEmpty(obj);
	}

	public static String concatStrings(String[] strings, boolean ignoreNullOrEmpty, String separator) {
		if (strings == null)
			return null;

		StringBuilder stringBuilder = new StringBuilder(strings.length * 8);

		if (strings.length > 0) {
			if (separator == null)
				separator = "";

			boolean addString;
			int addedString = 0;

			for (int i = 0; i < strings.length; i++) {
				addString = ignoreNullOrEmpty ? (strings[i] != null && !strings[i].isEmpty()) : true;

				if (addString) {
					if (addedString != 0)
						stringBuilder.append(separator);
					stringBuilder.append(strings[i]);

					addedString++;
				}
			}
		}

		return stringBuilder.toString();
	}
	
}

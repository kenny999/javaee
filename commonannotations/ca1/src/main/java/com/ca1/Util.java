package com.ca1;

public class Util {

	public static String transactionStatusToString(int st) {
		switch (st) {
		case 0:
			return "STATUS_ACTIVE";
		case 1:
			return "STATUS_MARKED_ROLLBACK";
		case 2:
			return "STATUS_PREPARED";
		case 3:
			return "STATUS_COMMITTED";
		case 4:
			return "STATUS_ROLLEDBACK";
		case 5:
			return "STATUS_UNKNOWN";
		case 6:
			return "STATUS_NO_TRANSACTION";
		case 7:
			return "STATUS_PREPARING";
		case 8:
			return "STATUS_COMMITTING";
		case 9:
			return "STATUS_ROLLING_BACK";
		default:
			return "unkown";

		}

	}

}

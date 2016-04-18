import fishAppSql.DBOperation;

public class Test01 {

	public static void main(String[] args) {

		DBOperation operation = new DBOperation();

		if (!operation.CreateDB("my_test_2")) {
			System.out.println("чёт не завелось_1!!");
		}

		if (!operation.DeliteDB("my_test")) {
			System.out.println("чёт не завелось_2!!");
		}

		System.out.println(operation.getListDBOnServer().toString());
	}
}

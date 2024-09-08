package week4;


public class ExceptionHandling {
	public static void main(String[] args) {
		try { // to bundle set of statments which may throw an Exception
				// stmt1

			String str = "abcdfdsfsd";
			String substr = str.substring(1, 3);
			//StringIndexOutOfBoundsException

			int arr[] = { 1, 2, 3, 4, 5 };

			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			} //ArrayIndexOutOfBoundsException
			

			met();
			// stmt2
		} 
		catch(StringIndexOutOfBoundsException se){
			System.out.println("String index Exception"+se);
		}
		catch(ArrayIndexOutOfBoundsException ae){
			System.out.println("Array index Exception"+ae);
		}
		catch(NumberFormatException ne){
			System.out.println("NumberFormatException "+ne);
		}
		catch (Exception e) {// set of statement which handles Exception
								// scenario
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
		finally{//always gets executed
			System.out.println("This is finally block");
		}
	}

	static void met() throws Exception {// allows callers of this method to
										// handle Exception scenario
		// Abc obj = new Abc();
		System.out.println("1....");
		String str = "567";

		int val = Integer.parseInt(str);

		System.out.println("2....");
		val *= 1.1;

		System.out.println(val);
		System.out.println("3....");
	}
}

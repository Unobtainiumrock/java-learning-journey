// About: This was me hacking around in an attempt to create a Java array which mimics an array in JavaScript.
// I know that arrays in JavaScript will dynamically resize and stuff, so isn't perfect.
// I also didn't bother to add the other methods from JavaScript's Array prototype.

// Challenge: My current challenge is/was trying to figure out how to access values by index on T[] list
// but I couldn't verify if they were being "pushed" into the genericArray's "list" property. Currently this
// isn't working, but I will revisit it later once I have a deeper understanding of Java fundamentals.

// Attempts: I tried to use @Override to change the toString method
// on the Java Object, but I ran into issues with casting.

// Why?: I love the flexibility of being able to add whatever you want to an array without declaring the types
// of what will be stored on it. The next steps for me would have been to make something that dynamically resizes as
// elements are added or removed.

// This was just a fun exercise and I don't think this is a practical thing to do, because
// it partly defeats the purpose of using Java if I'm trying to make Java into JavaScript.


public class Driver {
  final static int ARRAY_SIZE = 1000;
  private static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {	  
	 genericArray<String> array = new genericArray<>(ARRAY_SIZE);
   array.push("H");
   // This would give the error below
   // Exception in thread "main" java.lang.ClassCastException: java.base/[Ljava.lang.Object; cannot be cast to java.base/[Ljava.lang.String;
	 System.out.println(array.list[0]);
  }
}

class genericArray <T> { 
  int length = 0;
  int size;
	T[] list;
	
	@SuppressWarnings("unchecked")
	public genericArray(int size) {
    this.list = (T[]) new Object[size];
    this.size = size;
	}
	
	public void push(T val) {
    if (!(this.length >= size)) {
      this.list[length] = val;
      this.length++;
    }
	}
	
	public T pop() {
		T temp = this.list[this.list.length - 1];
		this.list[this.length - 1] = null;
		this.length--;
		return temp;
  }
  
}
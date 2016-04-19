package metaSearchEngine.program;

// Instances of classes that extend this interface are
// User objects that contain information on customers seeking
// various travel services. 

public abstract class UserClass {

	// Minimum attributes all User classes should contain: 
	protected String username;
	protected String id;	// unique for database usage. Initialized in constructor. Never changed. 
	protected String email;

	// Usage: username = changeUserName(newUserName);
	// Before: Both username and newUserName are Strings
	// 	   of length 3 <= username.length() <= 20 and 
	//	   consist only of numbers and letters and start with a letter
	// After: username has been changed to newUserName
	public abstract void setUserName(String newUserName);
	
	// Usage: email = setEmail(newEmail);
	// Before: Both variables are contain a valid email address.
	// 	  (They might for example match the regular expression
	//	   ^([\w−] + (? : \.[\w−]+)*)@((? : [\w−] + \.)*\w[\w−]0, 66)\.([a − z]2, 6(? : \.[a − z]2)?)$ )
	// After: email has been changed to newEmail.
	public abstract void setEmail(String newEmail);
}

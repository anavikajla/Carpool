/* This object will allow one to offer a ride and request for offered ride if any.*/

public class Carpool {

  public static void main (Strings Args[])
  {
  //ask for input from user, either to login or sign-up.
  }
/* Login method check access to the app and directs to user's page.*/
  public static void login()
  {
    user (x); //calls user method
  }

/* Sign_up method allows user to access the app and on completion directs to their page.*/
  public static void sign_up()
  {
    user (x); //calls user method
  }

/*User method will present different function of the app and direct to different service as per their choices.
It will take the name of the user from the login or sign_up methods to develop individual user's informations. */
public static void user(String name)
{
  Offerer O = new offerer("name"); // if user is offerer, a new object will be created under user's name.
  Rider r = new rider ("name"); // if user is requesting for a ride, a new object will be created under user's name.
}
}
/*Add_ride method will allow the user to add the detail of the ride to be offered and confirm it.*/
class Offerer(String name){}

/*request_ride method will allow user to access the offered rides and choose among them*/
class Rider(String name){}

/*confirm_ride method confirms the ride either offered or requested
public static void confirm_ride(String name){}*/


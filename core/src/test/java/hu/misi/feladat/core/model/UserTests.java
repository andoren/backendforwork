package hu.misi.feladat.core.model;
import org.junit.*;
import hu.misi.feladat.core.exceptions.*;
public class UserTests {
    User user;
    @Before
    public void Init(){
        user = new User();
    }
    @Test
    public void ValidPassowrdUser() throws InvalidPassword {
        user.setPassword("Feladat2020#");
    }
    @Test(expected = InvalidPassword.class)
    public void TooShortPassword() throws InvalidPassword{
        user.setPassword("#Aa2");
    }
    @Test(expected = InvalidPassword.class)
    public void TooLongPassword() throws InvalidPassword{
        user.setPassword("a#2A0aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test(expected = InvalidPassword.class)
    public void NoSpecialCharPassword() throws InvalidPassword{
        user.setPassword("Feladaat2020");
    }
    @Test(expected = InvalidPassword.class)
    public void NoUpperCharPassword() throws InvalidPassword{
        user.setPassword("feladat2020#");
    }
    @Test(expected = InvalidPassword.class)
    public void NoLowerChar() throws InvalidPassword{
        user.setPassword("FELADAT2020#");
    }
    @Test(expected = InvalidPassword.class)
    public void HasSpace() throws InvalidPassword{
        user.setPassword("FELADAT 2020#");
    }
    @Test(expected = InvalidPassword.class)
    public void HasTab() throws InvalidPassword{
        user.setPassword("Feladat   2020#");
    }
    @Test
    public void ValidUsername() throws InvalidUsernameException {
        user.setUsername("kiscica");
    }
    @Test(expected = InvalidUsernameException.class)
    public void EmptyUsername() throws InvalidUsernameException {
        user.setUsername("");
    }
    @Test(expected = InvalidUsernameException.class)
    public void NullUsername() throws InvalidUsernameException {
        user.setUsername(null);
    }
    @Test(expected = InvalidUsernameException.class)
    public void TooLongUsername() throws InvalidUsernameException {
        user.setUsername("aaaaaaaaaaaaaaaaaaaaa");
    }
    @Test
    public void TwentyLongUsername() throws InvalidUsernameException {
        user.setUsername("aaaaaaaaaaaaaaaaaaaa");
    }
    @Test
    public void FiveLongUsername() throws InvalidUsernameException {
        user.setUsername("aaaaa");
    }
    @Test(expected = InvalidUsernameException.class)
    public void FourLongUsername() throws InvalidUsernameException {
        user.setUsername("aaaa");
    }
    @Test
    public void ValidRealName() throws InvalidRealnameException {
        user.setRealname("Pekár Mihály");
    }
    @Test(expected = InvalidRealnameException.class)
    public void EmptyRealName() throws InvalidRealnameException {
        user.setRealname("");
    }
    @Test(expected = InvalidRealnameException.class)
    public void NullRealName() throws InvalidRealnameException {
        user.setRealname(null);
    }
    @Test(expected = InvalidRealnameException.class)
    public void ShortRealName() throws InvalidRealnameException {
        user.setRealname("1234");
    }
    @Test(expected = InvalidRealnameException.class)
    public void LongRealName() throws InvalidRealnameException {
        user.setRealname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test(expected = InvalidRealnameException.class)
    public void NoSpaceRealName() throws InvalidRealnameException {
        user.setRealname("MeowMeow");
    }
}

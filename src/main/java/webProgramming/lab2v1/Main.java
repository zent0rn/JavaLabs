package webProgramming.lab2v1;

import webProgramming.lab2v1.userInterface.entities.GUIDMatcherUI;
import webProgramming.lab2v1.userInterface.interfaces.UserInteface;

/*
Valid GUIDs:
{6F9619FF-8B86-D011-B42D-00CF4FC964FF}
d3aa88e2-c754-41e0-8ba6-4198a34aa0a2
(c56a4180-65aa-42ec-a945-5fd21dec0538)

Invalid GUIDs
C56A4180-65AA-42EC-A945-5FD21DEC
x56a4180-h5aa-42ec-a945-5fd21dec0538
 */

public class Main {
    public static void main(String[] args) {
        UserInteface userInteface = new GUIDMatcherUI();
        userInteface.run();
    }
}

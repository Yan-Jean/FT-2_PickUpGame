package mypackage;

 public abstract class Console {

  public static void superTab(String s) {
   System.out.println("\t\t\t\t\t\t\t\t\t" + s);
  }

  public static void playerWin() {
   System.out.println("\n\t !!! Congrats you got them all !!! Your are very patient and very brave !!!\n");
   superTab("---------");
   superTab("  ♦ ♦ ♦  ");
   superTab("  ♦ ♥ ♦  ");
   superTab("  ♦ ♦ ♦  ");
   superTab("---------\n");
  }
}

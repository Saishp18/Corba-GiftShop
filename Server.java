import GiftShop.*;
import java.util.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

class Server extends _giftintfImplBase {

  static Map<String, Integer> gift_list;
  static int[] prices;
  static int total;
  static int store;

  public Server() {
    total = 0;
    gift_list = new LinkedHashMap<String, Integer>();
    prices = new int[10];
    gift_list.put("Polaroids", 100);
    gift_list.put("Keychains", 20);
    gift_list.put("Earrings", 20);
    gift_list.put("PhotoFrame", 20);
    gift_list.put("GiftBox", 20);
    gift_list.put("Cards", 20);
    gift_list.put("Painting", 20);
    gift_list.put("ScrapBook", 20);
    gift_list.put("Stickers", 100);
    gift_list.put("Bookmarks", 20);

    prices[0] = 5;
    prices[1] = 50;
    prices[2] = 100;
    prices[3] = 120;
    prices[4] = 200;
    prices[5] = 100;
    prices[6] = 50;
    prices[7] = 150;
    prices[8] = 20;
    prices[9] = 25;
  }

  // checking for availabilty for gifts
  public String check_gift(String gift_id) {
    store = -1;
    int i = 0;
    if (!gift_list.containsKey(gift_id)) {
      return "Item not present";
    }

    String s = "";
    for (String ik : gift_list.keySet()) {
      if (ik.equals(gift_id)) {
        s =
          "Item present with total available quantity: " +
          gift_list.get(gift_id) +
          "\nPrice:" +
          prices[i];
        store = i;
        break;
      }
      i++;
    }
    return s;
  }

  // add to cart
  public String process_gift(String gift_id, int quantity) {
    int q = gift_list.get(gift_id);
    String s = "";
    if (q >= quantity) {
      total += prices[store] * quantity;
      gift_list.put(gift_id, gift_list.get(gift_id) - quantity);
      System.out.println(
        "Item " + gift_id + " ordered with quantities " + quantity
      );
      s = "Item added to cart";
    }
    return s;
  }

  //return total prices
  public int total_price() {
    return total;
  }

  public String pay_bill() {
    System.out.println("Payment successful with amount " + total);
    total = 0;
    return "Payment successful!\n";
  }

  public static void main(String[] args) {
    try {
      ORB orb = ORB.init(args, null);
      Server lbRef = new Server();
      orb.connect(lbRef);
      org.omg.CORBA.Object objRef = orb.resolve_initial_references(
        "NameService"
      );
      NamingContext ncRef = NamingContextHelper.narrow(objRef);
      NameComponent nc = new NameComponent("gifts", "");
      NameComponent path[] = { nc };
      ncRef.rebind(path, lbRef);
      System.out.println("Server started!");
      Thread.currentThread().join();
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}

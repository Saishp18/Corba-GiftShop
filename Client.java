import GiftShop.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;
class Client{
	public static void main(String[] args){
		try{
			int i;
			String j;
			Scanner sc=new Scanner(System.in);
			String s,b,a;
			ORB orb=ORB.init(args,null);
			org.omg.CORBA.Object objRef =
			orb.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			NameComponent nc=new NameComponent( "gifts" , "" );
			NameComponent path[] = {nc} ;
			giftintf lbref=giftintfHelper.narrow( ncRef.resolve(path) );
      // medintf lbref=medintfHelper.narrow( ncRef.resolve(path) );

      System.out.println("~~~~~~ Welcome to Hobbies&Love ~~~~~~");
      System.out.println("Gift catalog:");
      System.out.println("1 Polaroids");
      System.out.println("2 Keychains");
      System.out.println("3 Earrings");
      System.out.println("4 PhotoFrame");
      System.out.println("5 GiftBox");
      System.out.println("6 Cards");
      System.out.println("7 Painting");
      System.out.println("8 ScrapBook");
      System.out.println("9 Stickers");
      System.out.println("10 Bookmarks");
      
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      
      do{
				int p=0;
				System.out.println( ++p +".Check gift items");
				if(lbref.total_price() > 0){
							System.out.println( ++p +".Proceed to Payment");
				}
				System.out.println("0.Exit");
				System.out.print("Enter choice: ");
				i=sc.nextInt();
				switch(i){
					case 1:System.out.print("Enter gift item name: ");
					j=sc.next();
					s=lbref.check_gift(j);
					System.out.println(s);
					System.out.println("If you want to 	confirm type 'yes' else 'no'");
					b=sc.next();		a=b.toLowerCase();
					if(a.equals("yes")){
						 System.out.print("Enter number of quantities: ");
						 int y=sc.nextInt();
						 s=lbref.process_gift(j,y);
						 if(s.equals("")){
							 s="Sorry this gift item is not in stock!";
						 }
						 System.out.println(s);
					}
					break;

					case 2:int pay=lbref.total_price();
					System.out.println("Total amount to be paid: "+pay);
					System.out.println("If you want to pay type 'yes' else 'no' ");
						b=sc.next();		a=b.toLowerCase();
					if(a.equals("yes")){
						 s=lbref.pay_bill();
						 System.out.println(s);
					}
					break;

					default:
					if(lbref.total_price() > 0){
						System.out.println("Your cart amount: "+lbref.total_price());
 					 System.out.print("Do you want to pay? ");
 					 b=sc.next();		a=b.toLowerCase();
 					 if(a.equals("yes")){
 								 s=lbref.pay_bill();
 								 System.out.println(s);
 					 }
					}

					break;
				}
			}while(i!=0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

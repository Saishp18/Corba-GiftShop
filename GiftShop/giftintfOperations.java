package GiftShop;


/**
* GiftShop/giftintfOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from shop.idl
* Saturday, 3 April, 2021 12:34:27 PM IST
*/

public interface giftintfOperations 
{
  String check_gift (String gift_id);
  String process_gift (String gift_id, int quantity);
  int total_price ();
  String pay_bill ();
} // interface giftintfOperations
package GiftShop;

/**
* GiftShop/GiftHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from shop.idl
* Saturday, 3 April, 2021 12:34:27 PM IST
*/

public final class GiftHolder implements org.omg.CORBA.portable.Streamable
{
  public GiftShop.Gift value = null;

  public GiftHolder ()
  {
  }

  public GiftHolder (GiftShop.Gift initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GiftShop.GiftHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GiftShop.GiftHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GiftShop.GiftHelper.type ();
  }

}

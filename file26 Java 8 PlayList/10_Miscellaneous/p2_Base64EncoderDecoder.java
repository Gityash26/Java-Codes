/*
===============================================================================
                    Base64 Encoder Decoder
===============================================================================

Suppose you want to send the following files through the Internet.

    ✔ Image    ✔ PDF  ✔ Audio    ✔ Video

These files are stored inside the computer as Binary Data (Bytes).

Many communication systems (JSON, XML, Email, APIs) work better with Text data rather than 
Binary data.

So... 
    How can Binary Data be safely transferred as Text?
    To solve this problem, Java provides Base64 Encoding.


===============================================================================
What is Base64?
===============================================================================

The Base64 is an Encoding Technique that were introduces in java8 for a secure and 
effective trasnfer of information.

It converts Binary Data into Text format so that the data can be transmitted safely.

After receiving the Text, it can be converted back into the original 'Binary Data'.

NOTE
---------------------------------
-> Base64 is NOT Encryption.
-> It only changes the representation of data. (Binary to Text | Text to Bionary)
-> Anyone can decode Base64.


===============================================================================
Real Life Example
===============================================================================

Suppose you upload your Profile Picture.

Instead of directly sending the Image,
The application first converts it into a Base64 String.

That String is transferred through the Internet.

The receiver again converts the String back into the original Image.



===============================================================================
Visualization
===============================================================================

                Original Data
    _________________________________________
    │   Image      PDF      Audio           │
    │_______________________________________│
                    │
              Binary Data --- 0101101
                    │
        ____________│________________
        │    Base64 Encoding        │
        │___________________________│
                    │
             Text Representation  --- "SmF2YTEyMw=="
                    │
        ____________│________________
        │   Base64 Decoding         │
        │___________________________│
                    │
             Original Data Again
            (Image , PDF , Audio)



===============================================================================
Object Creation
===============================================================================

    Base64 class does not provide a public constructor.
    Instead, objects are created using static factory methods.


                Base64
                   │
         ┌─────────┴─────────┐
         │                   │
         ▼                   ▼
 getEncoder()          getDecoder()
         │                   │
         ▼                   ▼
 Encoder Object      Decoder Object


===============================================================================
Important Methods
===============================================================================


Encoder Object
==============================

-------------------------------------------------------
encodeToString(byte[])
-------------------------------------------------------
    -> Converts Binary Data into Base64 Text.



Decoder Object
==============================

-------------------------------------------------------
decode(String)
-------------------------------------------------------
    -> Converts Base64 Text back into Binary Data.


===============================================================================
Program
===============================================================================
*/

import java.util.Base64;

public class p2_Base64EncoderDecoder
{
    public static void encodeExample()
    {
        System.out.println("\n~~~~~~~~~~~~~~ Encoder methods ~~~~~~~~~~~~~~~~~~~");
        String text = "Hello java compiler";

        String encoded = Base64.getEncoder()
                               .encodeToString(text.getBytes());

        System.out.println("Original : " + text);
        System.out.println("Encoded  : " + encoded);

    }


    public static void decodeExample()
    {
        System.out.println("\n~~~~~~~~~~~~~~ Decoder methods ~~~~~~~~~~~~~~~~~~~");

        String encoded = "SmF2YSA4";
        byte[] bytes = Base64.getDecoder()
                             .decode(encoded);

        String decoded = new String(bytes);

        System.out.println("Encoded string: " + encoded);
        System.out.println("Decoded back to original data : " + decoded);
    }
    
    public static void main(String[] args)
    {
        encodeExample();
        decodeExample();
    }

}


/*

===============================================================================
Working
===============================================================================

Encoding

"Java 8"

        │

getBytes()

        │

byte[]

        │

Base64.getEncoder()

        │

encodeToString()

        │

"SmF2YSA4"



------------------------------------------------------------

Decoding

"SmF2YSA4"

        │

Base64.getDecoder()

        │

decode()

        │

byte[]

        │

new String()

        │

"Java 8"


===============================================================================
Output
===============================================================================

Original : Java 8

Encoded  : SmF2YSA4

Encoded  : SmF2YSA4

Decoded  : Java 8


===============================================================================
Remember
===============================================================================

✔ Base64 converts Binary Data into Text.

✔ Base64 can also convert the Text back into Binary Data.

✔ Base64 is Encoding, NOT Encryption.

✔ getEncoder() and getDecoder() are static factory methods.

✔ encodeToString() and decode() are instance methods.

===============================================================================
*/
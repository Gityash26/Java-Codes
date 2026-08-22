/*
╔══════════════════════════════════════════════════════════════════════════════╗
║                      Introduction of ByteStreams                             ║
╚══════════════════════════════════════════════════════════════════════════════╝

═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
Why Byte Streams?
════════════════════════════════════════════════════════════════════════════════
Till now, we already learnt the character stream are used to read or write the character data
But files are not always text files.

Examples:

        image.jpg
        song.mp3
        video.mp4
        document.pdf
        program.zip


These files contain raw binary data.

For such data, Java provides:

                            Byte Streams


════════════════════════════════════════════════════════════════════════════════
What is a Byte?
════════════════════════════════════════════════════════════════════════════════

A byte is a small unit of binary data.

            1 Byte = 8 bits

When a binary file is read, Java can process its data byte-by-byte.

Example

        image.jpg
        ┌──────────────────────────────┐
        │  Binary Data                 │
        │  10101100 01010101 11001010  │
        │  00110010 10101001 ...       │
        └──────────────┬───────────────┘
                       │
                       ▼
                  Byte Stream
                       │
                       ▼
                  Java Program


═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~═~
Byte Streams
════════════════════════════════════════════════════════════════════════════════
Just like character streams 
Java also provides two main abstract classes for Byte Streams:


                    Byte Streams
                        │
               ┌────────┴─────────┐
               ▼                  ▼
          InputStream         OutputStream
               │                  │
               ▼                  ▼
             READ               WRITE


        InputStream
            │
            └──────> Reading bytes


        OutputStream
            │
            └──────>Writing bytes



════════════════════════════════════════════════════════════════════════════════
Byte Streams for File
════════════════════════════════════════════════════════════════════════════════

For working directly with Files, Java provides:

    FileInputStream
            │
            ▼
        Reads bytes from File


    FileOutputStream
            │
            ▼
        Writes bytes into File


Hierarchy

        InputStream
            │
            └── FileInputStream


        OutputStream
            │
            └── FileOutputStream


Both are concrete classes.


════════════════════════════════════════════════════════════════════════════════
Character Stream vs Byte Stream
════════════════════════════════════════════════════════════════════════════════

Character Stream
             ↓
        Character-oriented


Byte Stream
             ↓
        Byte-oriented


════════════════════════════════════════════════════════════════════════════════
Where are Byte Streams useful?
════════════════════════════════════════════════════════════════════════════════

Byte Streams are useful when working with raw/binary data.

Examples:

        Images
        Audio
        Video
        PDF
        ZIP
        Executable files
        Other binary files


A byte stream does not try to interpret the data as characters or text.
It simply transfers the bytes.


════════════════════════════════════════════════════════════════════════════════
Basic Data Flow
════════════════════════════════════════════════════════════════════════════════

Reading

        Binary File
            │
            ▼
      FileInputStream
            │
            ▼
           Bytes
            │
            ▼
        Java Program


Writing

        Java Program
            │
            ▼
           Bytes
            │
            ▼
     FileOutputStream
            │
            ▼
        Binary File


════════════════════════════════════════════════════════════════════════════════
Important Takeaways
════════════════════════════════════════════════════════════════════════════════

✔ Byte Streams work with byte data.

✔ InputStream is used as the base abstraction for reading bytes.

✔ OutputStream is used as the base abstraction for writing bytes.

✔ FileInputStream reads bytes from a File.

✔ FileOutputStream writes bytes into a File.

✔ Byte Streams can work with both text and binary files.

✔ They are especially important for binary files such as images,
  audio, video, PDF and ZIP files.

══════════════════════════════════════════════════════════════════════════════
*/
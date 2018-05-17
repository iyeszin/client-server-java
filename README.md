# client-server

This is a group project for course Operating System.

Write a server using the Java networking API. 
This server will wait for a client connection using the accept() method.
When a client connection is received, the server will loop, performing the following steps:
- Read data from the socket into a buffer.
- Respond to the client based on the contents of the buffer. 
  The respond is listed in a text file stored locally.

The contents of the file are:
- "Life is about making an impact, not making an income. –Kevin Kruse"
- "Whatever the mind of man can conceive and believe, it can achieve. –Napoleon Hill"
- "Strive not to be a success, but rather to be of value. –Albert Einstein"
- "Two roads diverged in a wood, and I - I took the one less traveled by, And that has made all the difference.  –Robert Frost"
- "I attribute my success to this: I never gave or took any excuse. –Florence Nightingale"
- ""You miss 100% of the shots you don’t take. –Wayne Gretzky"
- "I’ve missed more than 9000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life. And that is why I succeed. –Michael Jordan"
- "The most difficult thing is the decision to act, the rest is merely tenacity. -Amelia Earhart"
- "Every strike brings me closer to the next home run. –Babe Ruth"
- "Definiteness of purpose is the starting point of all achievement. –W. Clement Stone"

The server will break out of the loop only when it has determined that the client has closed the connection.

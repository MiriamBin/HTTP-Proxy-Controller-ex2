# ex2

<h3>Miriam Binyamines</h3>
<h5>Email: miriamman@edu.hac.ac.il</h5>

<h3>Salomon Demma</h3>
<h5>Email: dennasa@edu.hac.ac.il</h5>

<h1>Counter Program </h1>
<a href="ex2-java-neviim-ex2_salomon_demma_miriam_binyamines/doc/ex2/package-summary.html">API documentation</a>

<h2>Console URL Program </h2>

we choose to use the desing pattern "singleton" to create the object of the class "Console" and to make sure that there is only one instance of the class "blocked list" in the program.
also we used factory design pattern to create the commands objects and to make sure that the program will be easy to add new commands in the future.
and we used command design pattern for the options of the download command.

<h2>Remarks</h2>
Any kind of white space in the command will be ignored - including space as command.
A local data structure to make searching and sorting easier


<h2>Tests </h2>
b https://en.wikipedia.org/wiki/Main_Page
b https://en.wikipedia.org/wiki/Main_Page1
b https://en.wikipedia.org/wiki/Main_Page2
b https://en.wikipedia.org/wiki/Main_Page3
p
u https://en.wikipedia.org/wiki/Main_Page
p
d -b https://en.wikipedia.org/wiki/Main_Page wiki.html
d -i https://en.wikipedia.org/wiki/Main_Page wiki.html
d -hi https://en.wikipedia.org/wiki/Main_Page wiki.html
d -ih https://en.wikipedia.org/static/images/mobile/copyright/wikipedia-wordmark-en.svg img.svg
d https:/en.wikipedia.org/wiki/Main_Page wiki.html
d i https://en.wikipedia.org/wiki/Main_Page abc
d -ik https://en.wikipedia.org/wiki/Main_Page abc
d -ch https://www.w3schools.com/codeeditor.gif codeeditor.gif
p
q
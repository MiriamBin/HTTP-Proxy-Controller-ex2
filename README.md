[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-8d59dc4de5201274e310e4c54b9627a8934c3b88527886e3b421487c677d23eb.svg)](https://classroom.github.com/a/cj2Bo1xr)
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
p
d https://www.wikipedia.org/ out.html
u https://www.wikipedia.org/
k
b https://www.wikipedia.org/
d -cb https://www.wikipedia.org/ out2.html
d -bc https://www.wikipedia.org/ out3.html
d https:/en.wikipedia.org/wiki/Main_Page
d -bci https://www.google.com/search?q=moodle&rlz=1C1GCEA_enIL1015IL1015&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiG2Yq2pvn9AhVBnVwKHZkNCbYQ_AUoAXoECAEQAw&biw=1920&bih=929&dpr=1#imgrc=-Pl0ssMV1S6bcM out4.html
d -bkc https://www.wikipedia.org/ out3.html
d https://mow out5.html
d -bc https://google.com
b
u
b
b  
-b
u jibrish
p
d -ccccccch       https://www.youtube.com       out6.html
d       https://www.youtube.com       out7.html
b     https://www.youtube.com
B https://www.youtube.com
P
U https://www.wikipedia.org/
d https://www.foo.software/api/v2 out8
d https://catfact.ninja/fact out9
d https://www.wikipedia.org/ out9
d - https://www.wikipedia.org/ out10
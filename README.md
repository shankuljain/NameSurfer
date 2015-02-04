# NameSurfer
This program represents the popularity of baby names in the form of graph.

Note : This program uses ACM library. Please download the .jar file while compliling the program from here http://jtf.acm.org.

Against all bureaucratic stereotypes, the Social Security Administration, provides a neat web site showing the distribution of
names chosen for children over the last 100 years in the United States (http://www.ssa.gov/OACT/babynames/). 
The Social Security Administration provides data that shows the 1000 most popular boy and girl names for children at 10 year
intervals. The data can be boiled down to a single text file that looks something like this:

NamesData.txt
￼
...
Sam 58 69 99 131 168 236 278 380 467 408 466 Samantha 0 0 0 0 0 0 272 107 26 5 7
Samara 0 0 0 0 0 0 0 0 0 0 886
Samir 0 0 0 0 0 0 0 0 920 0 798
Sammie 537 545 351 325 333 396 565 772 930 0 0 Sammy 0 887 544 299 202 262 321 395 575 639 755 Samson 0 0 0 0 0 0 0 0 0 0 915
Samuel 31 41 46 60 61 71 83 61 52 35 28
Sandi 0 0 0 0 704 864 621 695 0 0 0
Sandra 0 942 606 50 6 12 11 39 94 168 257
...
￼
Each line of the file begins with the name, followed by the rank of that name in each of the 11 decades since 1900, 
counting the current one: 1900, 1910, 1920, and so on up to 2000. A rank of 1 indicates the most popular name that year,
while a rank of 997 indicates a name that is not very popular. A 0 entry means the name did not appear in the top 1000 names
for that year and therefore indicates a name that is even less popular. The elements on each line are separated from each other
by a single space. The lines happen to be in alphabetical order, but nothing in the assignment depends on that fact.
As you can see from the small excerpt from the file, the name Sam was #58 in the first decade of the 1900s and is slowly 
moving down. Samantha popped on the scene in the 1960s (possibly because the show Bewitched, which had a main character names
Samantha ran on television during those years) and is moving up strong to #7. Samir barely appears in the 1980s (at rank #920)
, but by the current decade is up to #798. The database counts children born in the United States, so trends in particular
names tend to reflect the evolution of ethnic communities over the years.

The goal of this assignment is to create a program that graphs these names over time, as shown in the sample run in Figure 1.
In this diagram, the user has just typed Samantha into the box marked ―Name‖ and then clicked on the ―Graph‖ button, having 
earlier done exactly the same thing for the name Sam. Whenever the user enters a name, the NameSurfer program creates a new 
plot line showing how that name has fared over the decades. Clicking on the ―Clear‖ button removes all the plot lines from the
graph so that the user can enter more names without all the old names cluttering up the display.




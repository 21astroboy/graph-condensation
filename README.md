# graph-condensation

You are given a connected directed graph with N vertices and M edges (1 ≤ N ≤ 20000, 1 ≤ M ≤ 200000). 
Find the components of the strong connectivity of a given graph and topologically sort its condensation.


INPUT:
The graph is specified in the input file as follows: the first line contains the numbers N and M. 
Each of the following M lines contains a description of the edge – two integers from the range from 1 to N –
- the numbers of the beginning and end of the edge.

OUTPUT:
On the first line, print the number K – the number of components of strong connectivity in a given graph. 
On the next line, print N numbers – for each vertex, print the number of the component of strong connectivity
to which this vertex belongs. The components of strong connectivity should be numbered in such a way
that for any edge the number of the component of strong connectivity of its beginning does not exceed the number
of the component of strong connectivity of its end.

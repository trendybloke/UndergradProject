To run tests while in this directory, execute

'node benchmarks.js'.

Note that the unit given is operations per second; meaning results are given in how many times the function can run in one second. 
In order to get the time for one operation to complete, divide 1 by the result to now have an answer in units seconds per one operation.
The resulting value will have to be converted to nanoseconds by multiplying by 10^9.
From the documentation I have read of this library, this is the closest one can get to an answer in nanoseconds.
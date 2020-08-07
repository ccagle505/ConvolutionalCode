# ConvolutionalCode]

This program is a VERY basic implementation of Convolutional Code, which is an encoding scheme used to for error-correction. 
It is used extensively in mobile and satellite communications. 
This particular implementation uses a string of bit values as input. Each bit value in the string is stored in a set of registers. 
The stored values are summed using XOR operations to generate output bits.

A thorough explanation of convolutional coding can be found here:
https://ntrs.nasa.gov/search.jsp?R=19930020406

The Output bits can be decoded using a Viterbi algorithm.

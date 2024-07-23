package BitManipulatioin;

/* 
 * ### Mathematical Logic Behind the Problem

The problem of finding the maximum XOR value between any two numbers within a range ([l, r]) leverages properties of binary representation and the XOR (exclusive OR) operation. Here’s a detailed explanation of the logic:

#### XOR Operation

The XOR operation between two bits results in:
- ( 1 ) if the bits are different.
- ( 0 ) if the bits are the same.

For example:
- ( 1 ^ 0 = 1 )
- ( 0 ^ 1 = 1 )
- ( 1 ^ 1 = 0 )
- ( 0 ^ 0 = 0 )

#### Key Observations

1. Difference in Bits:
   - When you XOR two numbers, the resulting binary number has bits set to `1` where the corresponding bits of the original numbers differ. For example, for ( l = 10 ) and ( r = 15 ):
   - ( 10 ) in binary: `1010`
   - ( 15 ) in binary: `1111`
   - ( 10 ^ 15 ): `0101` (binary) = `5` (decimal)

2. Significance of the Most Significant Bit (MSB):
   - The position of the most significant bit set to `1` in the XOR result indicates the highest position at which the two numbers differ.
   - This position helps determine the maximum range of values that can be achieved by changing bits from `0` to `1` and vice versa in the range ([l, r]).

3. Maximum Possible XOR:
   - If the MSB of the XOR result is at position ( n ), then to maximize the XOR value, we should fill all bits from the MSB down to the least significant bit (LSB) with `1`.
   - This is because having all bits set to `1` gives the highest possible value in binary.
   - For example, if the MSB is at position 2 (counting from 0), then the maximum value is `111` in binary, which is `7` in decimal.

### Detailed Explanation with Example

Consider the range ( l = 10 ) and ( r = 15 ):

1. Calculate ( l ^ r ):
   - ( l = 10 ) in binary: `1010`
   - ( r = 15 ) in binary: `1111`
   - ( 10 ^ 15 = 0101 ) (binary) = `5` (decimal)

2. Find the MSB Position:
   - The binary result `0101` has its MSB at position 2 (from the right, 0-indexed).

3. Compute the Maximum XOR Value:
   - For position 2, the maximum binary value with bits filled from the MSB to the LSB is `111` (binary).
   - `111` in binary is `7` in decimal.
   - Hence, the maximum XOR value for the range [10, 15] is `7`.

### Generalized Mathematical Steps

1. Compute ( l ^ r ):
   - This reveals the positions where ( l ) and ( r ) differ.

2. Identify the MSB of the XOR Result:
   - Determine the position of the highest bit set to `1`.

3. Formulate the Maximum Value:
   - If the MSB is at position ( n ), the maximum value with `n+1` bits all set to `1` is ( 2^{(n+1)} - 1 ).

For example:
- If the XOR result is `1101`, the MSB is at position 3.
- The maximum value is ( 2^{(3+1)} - 1 = 2^4 - 1 = 15 ).


### Explanation of the Code

1. Computing ( l ^ r ):
   - `int xorValue = l ^ r;`

2. Finding the MSB Position:
   - The while loop shifts `xorValue` right until it becomes 0, counting the number of shifts (which corresponds to the bit position).

3. Formulating the Maximum XOR:
   - `(1 << msbPosition) - 1` generates a number with all bits set to `1` up to the MSB position.

This approach ensures that we find the maximum XOR value efficiently for any given range [l, r].
 */

public class MaximizingXOR {
   public static void main(String[] args) {
      int l = 10, r = 15;
      System.out.println(maximumXOR(l, r));
   }

   private static int maximumXOR(int l, int r) {
      // find the xor between l and r
      int xor = l ^ r;

      int msbPosition = 0;
      // find the 1st bit from msb set to 1
      while (xor > 0) {
         msbPosition++;
         xor = xor >> 1;
      }

      /*
       * If the nth bit from left (counting from 0) is set then 2^(n+1) - 1 will the
       * maxximum xor.
       */
      return (1 << msbPosition) - 1;
   }
}

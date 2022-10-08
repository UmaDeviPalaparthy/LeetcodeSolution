Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1


**Solution notes:**

**Complexity Analysis**

Time Complexity: O(log⁡(x))O(\log(x))O(log(x)). There are roughly log⁡10(x)\log_{10}(x)log 
10
​
 (x) digits in xxx.
Space Complexity: O(1)O(1)O(1).


To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.
```
//pop operation:
pop = x % 10;
x /= 10;

//push operation:
temp = rev * 10 + pop;
rev = temp;
```
However, this approach is dangerous, because the statement temp=rev⋅10+pop\text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop can cause overflow.

Luckily, it is easy to check beforehand whether or this statement would cause an overflow.

To explain, lets assume that rev\text{rev}rev is positive.

If temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop causes overflow, then it must be that rev≥INTMAX10\text{rev} \geq \frac{INTMAX}{10}rev≥ 
10
INTMAX
​
 
If rev>INTMAX10\text{rev} > \frac{INTMAX}{10}rev> 
10
INTMAX
​
 , then temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop is guaranteed to overflow.
If rev==INTMAX10\text{rev} == \frac{INTMAX}{10}rev== 
10
INTMAX
​
 , then temp=rev⋅10+poptemp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop will overflow if and only if pop>7\text{pop} > 7pop>7
Similar logic can be applied when rev\text{rev}rev is negative.

#Reflected Gray code generation

1. Create a 2^n int array
2. Initialize the first element to 0. The already generated length `len=1`. Highest bits `m=0`
3. Generate next `len` elements by
3.1. Copy the previous `len` backwards, ie `nums[0..len]=nums[len*2..len]`
3.2. appending bit 1 at position `m` for newly generated elements.

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdint>
#include <sstream>
using namespace std;

uint64_t higher32Bits(uint64_t in) {
  return (in>>32);
}

uint64_t lower32Bits(uint64_t in) {
  return (in<<32)>>32;
}

void add(uint64_t in1, uint64_t in2, uint64_t carryIn, uint64_t& out, uint64_t& carryOut) {
  uint64_t tmp = in1+in2;
  if (tmp<in1) { //Overflow
    out=tmp;
    carryOut = 1ULL;
  } else { //Normal
    out = tmp;
    carryOut = 0ULL;
  }
  if (carryIn>0) {
    uint64_t carryOut2 = 0;
    add(out, carryIn, 0, out,carryOut2);
    carryOut += carryOut2;
  }
}

void multiply(uint64_t in1, uint64_t in2, uint64_t& outL,uint64_t& outH) {
  uint64_t l1 = lower32Bits(in1);
  uint64_t h1 = higher32Bits(in1);
  uint64_t l2 = lower32Bits(in2);
  uint64_t h2 = higher32Bits(in2);
  uint64_t l1l2=l1*l2;
  uint64_t l1h2=l1*h2;
  uint64_t h1l2=h1*l2;
  uint64_t h1h2=h1*h2;
  uint64_t carry1=0;
  uint64_t carry2=0;
  add(l1l2, l1h2<<32, 0ULL, outL, carry1);
  cout<<outH << " "<< outL<<carry1<<endl;
  add(outL, h1l2<<32, 0ULL, outL, carry2);
  cout<<outH << " "<< outL<<endl;
  add(l1h2>>32, h1l2>>32, carry1+carry2, outH, carry1);
  cout<<outH << " "<< outL<<endl;
  add(outH, h1h2, 0ULL, outH, carry1);
  cout<<outH << " "<< outL<<endl;
}

class BigInteger {
  vector<uint64_t> *data;
 public:
  BigInteger(uint64_t n){
    data = new vector<uint64_t>(10);
    data->push_back(n);
  }
  ~BigInteger(){
    delete data; 
  }

  void mult(BigInteger in) {

  }

  string toString() {
    stringstream buffer;
    for (int i=data->size()-1; i>=0; --i) {
      buffer << (*data)[i];
    }
    return buffer.str();
  }
};

int factorial(int n) {
  if (n<=1) {
    return 1;
  } else {
    return factorial(n-1)*n;
  }
}

int main(){
  int n;
  cin >> n;
  //cout<<factorial(20);
  uint64_t outH;
  uint64_t outL;

  multiply((1ULL<<2), 1ULL<<63, outL, outH);
  cout<<outH << " "<< outL<<endl;

  return 0;
}


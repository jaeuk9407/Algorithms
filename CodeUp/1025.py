number = input();
for i in range(len(number)):
  print("[%d]" %(int(number[i]) * 10**(len(number)-(i+1))))
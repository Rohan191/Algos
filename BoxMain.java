class Box
{
 private double width, height, depth;
 
 public Box(double w, double h, double d)
 {
  width=w;
  height=h;
  depth=d;
 }

 public Box(double s)
 {
  width=height=depth=s;
 }

 public Box()
 {
  width=height=depth=0;
 }
 
 public Box(Box b)
 {
  width=b.width;
  height=b.height;
  depth=b.depth;
 }
 
 public double volume()
 {
  double v=width*height*depth;
  return v;
 }
}


class BoxMain
{
 public static void main(String args[])
 {
  Box b1=new Box(2,3,4);
  Box b2=new Box(5);
  Box b3=new Box();
  Box b4=new Box(b1);

  double v1=b1.volume();
  double v2=b2.volume();
  double v3=b3.volume();
  double v4=b4.volume();
  
  System.out.println("Volume of Box1: "+v1);
  System.out.println("Volume of Box2: "+v2);
  System.out.println("Volume of Box3: "+v3);
  System.out.println("Volume of Box4: "+v4);
 }
}


/*
Output:

D:\java\bin>javac BoxMain.java

D:\java\bin>java BoxMain
Volume of Box1: 24.0
Volume of Box2: 125.0
Volume of Box3: 0.0
Volume of Box4: 24.0

*/
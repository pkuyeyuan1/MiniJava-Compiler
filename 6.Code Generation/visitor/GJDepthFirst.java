//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
	public class simpleexprret{
		int flag;
		String value;
	};
	int a,b,c;
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() ){
    	  String l=(String)n.node.accept(this,argu);
    	  System.out.println("\n"+l+":\n");
         return (R)l;
      }
      else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> "MAIN"
    * f1 -> "["
    * f2 -> IntegerLiteral()
    * f3 -> "]"
    * f4 -> "["
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    * f7 -> "["
    * f8 -> IntegerLiteral()
    * f9 -> "]"
    * f10 -> StmtList()
    * f11 -> "END"
    * f12 -> ( Procedure() )*
    * f13 -> VariablePackingInfo()
    * f14 -> <EOF>
    */
   public R visit(Goal n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String l1=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String l2=(String) n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      String l3=(String)n.f8.accept(this, argu);
      a=Integer.parseInt(l1);b=Integer.parseInt(l2);c=Integer.parseInt(l3);
      n.f9.accept(this, argu);
      Integer temp;
      if(Integer.parseInt(l3)>4)
    	  	temp=((Integer.parseInt(l3)-4)*4+4);
      else
    	  temp=4;
      System.out.println("\t.text\n.globl\tmain\nmain:\n move $fp, $sp \n subu $sp, $sp, "+temp+" \n sw $ra, -4($fp)");
          	  
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      System.out.println("\n lw $ra, -4($fp)\n addu $sp, $sp, "+temp+"\n");
      System.out.println("li $v0 10\n syscall\n");
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      System.out.println(".text \n .globl _halloc \n _halloc: \n li $v0, 9 \n syscall \n jr $ra \n .text \n .globl _print \n _print: \n li $v0, 1 \n syscall \n la $a0, newl \n li $v0, 4 \n syscall \n jr $ra \n .data \n .align   0 \n newl:    .asciiz \"\\n\" \n .data \n .align   0 \n str_er:  .asciiz \" ERROR: abnormal termination\\n\" ");
      
      return _ret;
   }

   /**
    * f0 -> ( ( Label() )? Stmt() )*
    */
   public R visit(StmtList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Label()
    * f1 -> "["
    * f2 -> IntegerLiteral()
    * f3 -> "]"
    * f4 -> "["
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    * f7 -> "["
    * f8 -> IntegerLiteral()
    * f9 -> "]"
    * f10 -> StmtList()
    * f11 -> "END"
    */
   public R visit(Procedure n, A argu) {
      R _ret=null;
      String funcname=(String)n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      int l1=Integer.parseInt((String)n.f2.accept(this, argu));
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      int l2=Integer.parseInt((String)n.f5.accept(this, argu));
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      int l3=Integer.parseInt((String)n.f8.accept(this, argu));
      a=(l1);b=(l2);c=(l3);
      n.f9.accept(this, argu);
      System.out.println("\t .text \n \t .globl \t "+funcname+"\n"+funcname+":\n");
      Integer temp;
      if(l3>4)
    	  temp=(l3-4+l2+2)*4;
      else
    	  temp=(l2+2)*4;
      System.out.println("sw $fp, -8($sp) \n move $fp, $sp \n subu $sp, $sp, "+temp+"\n sw $ra, -4($fp)");
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      int temp2=temp-8;
      System.out.println("lw $ra, -4($fp) \n lw $fp, "+temp2+"($sp) \n addu $sp, $sp, "+temp+"\n jr $ra \n \n");
      return _ret;
   }

   /**
    * f0 -> NoOpStmt()
    *       | ErrorStmt()
    *       | CJumpStmt()
    *       | JumpStmt()
    *       | HStoreStmt()
    *       | HLoadStmt()
    *       | MoveStmt()
    *       | PrintStmt()
    *       | ALoadStmt()
    *       | AStoreStmt()
    *       | PassArgStmt()
    *       | CallStmt()
    */
   public R visit(Stmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "NOOP"
    */
   public R visit(NoOpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      System.out.println("nop\n");
      return _ret;
   }

   /**
    * f0 -> "ERROR"
    */
   public R visit(ErrorStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      //System.out.println("la $a0, str_er\nsyscall\n li $v0, 10\n syscall\n");
      System.out.println("li $v0 4\nla $a0, str_er\nsyscall\n li $v0, 10\n syscall\n");
      return _ret;
   }

   /**
    * f0 -> "CJUMP"
    * f1 -> Reg()
    * f2 -> Label()
    */
   public R visit(CJumpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String r1=(String)n.f1.accept(this, argu);
      String l=(String)n.f2.accept(this, argu);
      System.out.println("beqz $"+r1+" "+l+"\n");
      return _ret;
   }

   /**
    * f0 -> "JUMP"
    * f1 -> Label()
    */
   public R visit(JumpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String l=(String)n.f1.accept(this, argu);
      System.out.println("b "+l+"\n");
      return _ret;
   }

   /**
    * f0 -> "HSTORE"
    * f1 -> Reg()
    * f2 -> IntegerLiteral()
    * f3 -> Reg()
    */
   public R visit(HStoreStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String r1=(String)n.f1.accept(this, argu);
      String off=(String)n.f2.accept(this, argu);
      String r2=(String)n.f3.accept(this, argu);
      System.out.println("sw $"+r2+", "+off+"($"+r1+")\n");
      return _ret;
   }

   /**
    * f0 -> "HLOAD"
    * f1 -> Reg()
    * f2 -> Reg()
    * f3 -> IntegerLiteral()
    */
   public R visit(HLoadStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String r1=(String)n.f1.accept(this, argu);
      String r2=(String)n.f2.accept(this, argu);
      String off=(String)n.f3.accept(this, argu);
      System.out.println("lw $"+r1+", "+off+"($"+r2+")\n");
      return _ret;
   }

   /**
    * f0 -> "MOVE"
    * f1 -> Reg()
    * f2 -> Exp()
    */
   public R visit(MoveStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      R reg=n.f1.accept(this, argu);
      argu=(A)reg;
      n.f2.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "PRINT"
    * f1 -> SimpleExp()
    */
   public R visit(PrintStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      
      simpleexprret s=(simpleexprret)n.f1.accept(this, argu);
      switch (s.flag){
      case 0: System.out.println("move $a0 $"+s.value+"\n");break;
      case 1: System.out.println("li $a0 "+s.value+"\n");break;
      case 2: System.out.println("la $a0 "+s.value+"\n");break;
      }
      System.out.println("jal _print \n");
      
      return _ret;
   }

   /**
    * f0 -> "ALOAD"
    * f1 -> Reg()
    * f2 -> SpilledArg()
    */
   public R visit(ALoadStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String reg=(String)n.f1.accept(this, argu);
      String spilledarg=((String)n.f2.accept(this, argu));
      System.out.println("lw $"+reg+", "+spilledarg+"\n");
      return _ret;
   }

   /**
    * f0 -> "ASTORE"
    * f1 -> SpilledArg()
    * f2 -> Reg()
    */
   public R visit(AStoreStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String spilledarg=(String)n.f1.accept(this, argu);
      String reg=(String)n.f2.accept(this, argu);
      System.out.println("sw $"+reg+", "+spilledarg+"\n");
      return _ret;
   }

   /**
    * f0 -> "PASSARG"
    * f1 -> IntegerLiteral()
    * f2 -> Reg()
    */
   public R visit(PassArgStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      int num=Integer.parseInt((String)n.f1.accept(this, argu));
      String reg=(String)n.f2.accept(this, argu);
      System.out.println("sw $"+reg+", "+((num-1)*4)+"($sp)\n");
      return _ret;
   }

   /**
    * f0 -> "CALL"
    * f1 -> SimpleExp()
    */
   public R visit(CallStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      simpleexprret s=(simpleexprret)n.f1.accept(this, argu);
      if(s.flag==0)
    	  System.out.println("jalr $"+s.value+"\n");
      else if(s.flag==2)
    	  System.out.println("jal "+s.value+"\n");
      return _ret;
   }

   /**
    * f0 -> HAllocate()
    *       | BinOp()
    *       | SimpleExp()
    */
   public R visit(Exp n, A argu) {
      R _ret=null;
      simpleexprret s=(simpleexprret)n.f0.accept(this, argu);
      
      if(n.f0.which==2){
    	  switch (s.flag){
          case 0: System.out.println("move $"+(String)argu+" $"+s.value+"\n");break;
          case 1: System.out.println("li $"+(String)argu+" "+s.value+"\n");break;
          case 2: System.out.println("la $"+(String)argu+" "+s.value+"\n");break;
          }
      }
      return _ret;
   }

   /**
    * f0 -> "HALLOCATE"
    * f1 -> SimpleExp()
    */
   public R visit(HAllocate n, A argu) {
      R _ret=null;
      //System.out.println("HELLO");
      n.f0.accept(this, argu);
      simpleexprret s=(simpleexprret)n.f1.accept(this, argu);
      //System.out.println(s.flag+"\n");
      if(s.flag==1)
    	  System.out.println("li $a0 "+s.value+"\n jal _halloc \n move $"+(String)argu+" $v0");
      if(s.flag==0)
    	  System.out.println("move $a0 $"+s.value+"\n jal _halloc \n move $"+(String)argu+" $v0");
      simpleexprret s1=new simpleexprret();
      s1.flag=-1;
      return (R)s1;
   }

   /**
    * f0 -> Operator()
    * f1 -> Reg()
    * f2 -> SimpleExp()
    */
   public R visit(BinOp n, A argu) {
      R _ret=null;
      String op=(String)n.f0.accept(this, argu);
      String reg=(String)n.f1.accept(this, argu);
      simpleexprret s=new simpleexprret();
      s=(simpleexprret)n.f2.accept(this, argu);
      if(s.flag==0)
    	  	System.out.println(op+" $"+(String)argu+", $"+reg+", $"+s.value+"\n");
      if(s.flag==1){
    	if ( op.equals("slt "))
    		op="slti ";
  	  	System.out.println(op+" $"+(String)argu+", $"+reg+", "+s.value+"\n");
      }
      
      simpleexprret s1=new simpleexprret();
      s1.flag=-1;
      return (R)s1;
   }

   /**
    * f0 -> "LT"
    *       | "PLUS"
    *       | "MINUS"
    *       | "TIMES"
    *       | "BITOR"
    *       | "BITAND"
    *       | "LSHIFT"
    *       | "RSHIFT"
    *       | "BITXOR"
    */
   public R visit(Operator n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      switch(n.f0.which){
      case 0: return (R)"slt ";
      case 1: return (R)"add ";
      case 2: return (R)"sub ";
      case 3: return (R)"mul ";
      case 4: return (R)"or ";
      case 5: return (R)"and ";
      case 6: return (R)"sll ";
      case 7: return (R)"srl ";
      case 8: return (R)"xor ";
      
      
      
      }
      return _ret;
   }

   /**
    * f0 -> "SPILLEDARG"
    * f1 -> IntegerLiteral()
    */
   public R visit(SpilledArg n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      int num=Integer.parseInt((String)n.f1.accept(this, argu));
      int temp=0;
      if(a>4){
    	  temp=a-4;
    	  if(num<temp)
    		  return (R)(" "+(num*4)+"($fp) ");
      }
      num=num-temp;
      if(c>4)
    	  num+=(c-4);
      num=num*4;
      
      
      return (R)(" "+num+"($sp) ");
   }

   /**
    * f0 -> Reg()
    *       | IntegerLiteral()
    *       | Label()
    */
   public R visit(SimpleExp n, A argu) {
      R _ret=null;
      simpleexprret s=new simpleexprret();
      s.value=(String)n.f0.accept(this, argu);
      s.flag=n.f0.which;
      //System.out.println("JJJJJJ "+s.flag+s.value+"\n");
      return (R)s ;
   }

   /**
    * f0 -> "a0"
    *       | "a1"
    *       | "a2"
    *       | "a3"
    *       | "t0"
    *       | "t1"
    *       | "t2"
    *       | "t3"
    *       | "t4"
    *       | "t5"
    *       | "t6"
    *       | "t7"
    *       | "s0"
    *       | "s1"
    *       | "s2"
    *       | "s3"
    *       | "s4"
    *       | "s5"
    *       | "s6"
    *       | "s7"
    *       | "t8"
    *       | "t9"
    *       | "v0"
    *       | "v1"
    */
   public R visit(Reg n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      switch(n.f0.which){
      case 0: return (R)"a0";
      case 1: return (R)"a1";
      case 2: return (R)"a2";
      case 3: return (R)"a3";
      case 4: return (R)"t0";
      case 5: return (R)"t1";
      case 6: return (R)"t2";
      case 7: return (R)"t3";
      case 8: return (R)"t4";
      case 9: return (R)"t5";
      case 10: return (R)"t6";
      case 11: return (R)"t7";
      case 12: return (R)"s0";
      case 13: return (R)"s1";
      case 14: return (R)"s2";
      case 15: return (R)"s3";
      case 16: return (R)"s4";
      case 17: return (R)"s5";
      case 18: return (R)"s6";
      case 19: return (R)"s7";
      case 20: return (R)"t8";
      case 21: return (R)"t9";
      case 22: return (R)"v0";
      case 23: return (R)"v1";
      }
      return (R)n.f0.toString();
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R)n.f0.toString();
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Label n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return (R) n.f0.toString();
   }

   /**
    * f0 -> "// Number of  vars after packing ="
    * f1 -> IntegerLiteral()
    * f2 -> "; Number of Spilled vars ="
    * f3 -> IntegerLiteral()
    */
   public R visit(VariablePackingInfo n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      return _ret;
   }

}
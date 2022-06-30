// filename: hello.thrift
namespace java thrift.hello  // thrift.hello 表示后面生成的代码放到哪个位置
service Hello{
 string helloString(1:string para)
 i32 helloInt(1:i32 para)
 bool helloBoolean(1:bool para)
 void helloVoid()
 string helloNull()
}

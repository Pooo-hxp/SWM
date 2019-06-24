var keywords=['help','系统首页','个人信息','个人考勤','个人薪资','信息公开','javascript','java',
'vue','bootstrap','jquery','mysql','前端','前端开发','Web页面','前端入门','php','c',
'c++','c#','xml']; //搜索候选关键字
var keyhtml=['help','Staff','StaffInfo','CheckInfo','CheckInfo','Payroll',
'js/js-tutorial','java/java-tutorial','vue2/vue-tutorial','bootstrap/bootstrap-tutorial',
'jquery/jquery-tutorial','mysql/mysql-tutorial','html/html-tutorial','html/html-tutorial',
'html/html-tutorial','html/html-tutorial','/php/php-tutorial','cprogramming/c-tutorial',
'cplusplus/cpp-tutorial','csharp/csharp-tutorial','xml/xml-tutorial'] //关键字网址
var txt=document.getElementById("select");
var btn=document.getElementById("btn");
var  ol=document.getElementById("ol");
var flag="";
txt.onclick=function(){
    txt.value="";
}
txt.onkeyup=function(){
    ol.innerHTML="";//每次搜索清空列表，防止二次搜索数据叠加
    if(this.value){
        
        for (let index = 0; index < keywords.length; index++) {
            if (keywords[index].indexOf(this.value)!=-1) {
                var li=document.createElement("li");
                li.innerHTML=keywords[index];
                ol.appendChild(li);
                ol.style.display="block";
                  li.onclick= function () {
                    txt.value=this.innerHTML; 
                    flag=keywords.indexOf(txt.value);//选取关键字下标
                    ol.style.display="none";
                };
                ol.onmouseleave=function(){
                    ol.style.display="none";
                };
               // btn.onclick.windows.loc
         btn.onclick=function auto(){
             var x='http://www.runoob.com/';
             var y=keyhtml[flag]+".html";
             flag>=6?window.open(x+y):window.open(y);           
            // if (flag<6) {   //判定是否要访问外部网页
            //     window.open(keyhtml[flag]+'.html');
            // } else {
            //     window.open('http://www.runoob.com/'+keyhtml[flag]+'.html');
            // }
       };
      }
    }
  }
}
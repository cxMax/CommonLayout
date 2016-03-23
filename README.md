# CommonLayout
<h1>中文使用说明</h1>
<h4>介绍</h4></br>
<p>对于有类似布局的不同activity,我用RecyclerView和接口来使用一个布局实现多个activity.通过工厂方法,来初始化RecyclerView,并且通过接口的抽象方法,在对应的activity进行对应的逻辑处理</p></br>
<h4>使用到的技术点</h4></br>
<p>RecyclerView自适应高度和自定义RecyclerView的divider,可以通过暴露出来的set方法来设置具体想要的参数</p></br>
<h4>使用方式</h4></br>
<p>因为是使用RecyclerView来实现相似布局,所以如果有新的item</p></br>
<p>1.首先你需要在xml文件里,建立一个item的布局文件.</p></br>
<p>2.然后在com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean包下面,去创建当前复杂布局的实体类,也就是通过type来组成多个item,最后通过这个实体类来实现MyType接口的selfType()抽象方法,来实现初始化RecyclerView.</p></br>
<p>3.因为新增的布局文件,可能需要绑定点击事件监听,可以在com.max.administrator.commonlayout.common.baseadapter.utils.factory包下面的ItemClickListener接口来增加对应的抽象方法即可,具体业务逻辑在activity中就能实现.</p></br>
<p>4.需要new一个ViewHolder来实现当前的界面控件初始化</p></br>
<p>5.初始化一个activity,去继承CommonLayoutBaseActivity,然后去重写initView(),initType(),initViewRecyclerView()这三个方法即可</p></br>
<h4>TODO</h4></br>
<p>使用EventBus实现模块间通信</p></br>

<h1>State</h1>
<p>the modules of android application which have the similar xml file,So I used RecyclerView and Interface to manger those activities </p></br>

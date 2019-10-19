package com.don.reactor;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/19/19 8:34 PM
 * @Version 1.0
 * @Description:
 **/

/**
 * TODO:Reactor模式的角色构成（Reactor模式一共有5种角色构成）
 * 1.Handle(句柄或是描述符):本质上是表示一种资源，是由操作系统提供的；该资源用于表示一个个的事件，比如说文件描述符，或者是针对于网络编程
 * 中的Socket描述符。事件既可以来自外部，也可以来自内部；外部事件比如说客户端的连接请求，客户端发送过来的数据等；内部事件比如说操作系统
 * 产生的定时器事件等。他本质上就是一个文件描述符。Handle是事件产生的发源地。
 *
 * 2.Synchronous Event Demultiplexer (同步事件分离器)：他本身是一个系统调用，用于等待事件的发生（事件可能是一个或多个）.调用方在调用
 * 它的时候会被阻塞，一直阻塞到同步事件分离器上有事件产生为止。对于Linux来说，同步事件分离器指的是常用的I/O多路复用机制，比如说：select
 * 、poll、epoll等。在Java NIO领域中，同步事件分离器对应的组件就是Selector;对应的阻塞方法就是select方法。
 *
 * 3.Event Handler (事件处理器)：本身由多个回调方法构成，这些回调方法构成了与应用相关的某个事件的反馈机制。Netty相比于Java NIO 来说
 * 在事件处理器这个角色上进行一个升级，他为我们开发者提供了大量的回调方法，提供我们在特定的事件产生时实现相应的回调方法进行业务逻辑处理。
 *
 * 4.Concrete Event Handler (具体事件处理器):是事件处理器的实现。他本身定义了实现事件处理器所提供的各个回调方法，从而实现特定的业务
 * 逻辑，他本质上是我们编写的一个个的处理器实现。
 *
 * 5.Initiation Dispatcher (初始分发器)：实际上就是Reactor角色。他本身定义了一些规范，这些规范用于控制事件的的调度方式，同时又提供了
 * 应用进行事件处理器的注册、删除等设施。他本身是整个事件处理器的核心所在，Initiation Dispatcher 会通过同步事件分离器来等待事件的发生
 * 一旦事件发生，Initiation Dispatcher 首先会分离出每一个事件、然后调用事件处理器，最后调用相关的回调方法来处理来处理这些事件。
 *
 *
 * TODO:Reactor模式的流程
 * 1.当应用向Initiation Dispatcher注册具体的事件处理器时，应用会标识出该事件处理器希望Initiation Dispatcher 在某个事件发生时向其
 * 通知的该事件，该事件与Handle关联
 *
 * 2.Initiation Dispatcher 会要求每个事件处理器向其传递内部的handler、该handler向操作系统标识了事件处理器。
 *
 * 3.当所有的事件处理器注册完毕后，应用会调用handler_events方法来启动Initiation Dispatcher的事件循环。这时，Initiation Dispatcher会将
 * 每个注册的事件管理器的handle合并起来，并使用同步事件分离器等待这些事件的发生。比如说：tcp协议层会使用select同步事件分离器操作来等待客户端
 * 发送的数据到达连接的socket handler上
 *
 * 4.当与某个事件源对应的Handler变为ready状态时(比如说：tcp socket 变为等待状态时),同步事件分离器就会通知Initiation Dispatcher。
 *
 * 5.Initiation Dispatcher 会触发事件处理器的回调方法，从而响应这个处于ready状态的Handler,当事件发生时,Initiation Dispatcher 会被事件
 * 源激活Handler作为[key]来寻找并分发恰当的事件处理器回调方法.
 *
 * 6.Initiation Dispatcher会回调事件处理器的handler_events回调方法来执行特定于应用的功能(开发者自己所编写的功能),从而响应这个事件、所发生
 * 的事件类型可以作为该方法的参数并被该方法内部使用来执行额外的特定服务的分离与开发。
 */

public class Reactor {
}

$.root_ = $('body');

//设置导航是否启用ajax模式
$.navAsAjax = true;

//设置是否启用提示音,和提示音的文件路径
$.sound_path = "sound/";
$.sound_on = true;

//设置一个全局的引用
var root = this,

//debug模式,设置debugState=true启用,在控制台打印所有的调试信息
debugState = false,
debugStyle = 'font-weight: bold; color: #00f;',
debugStyle_green = 'font-weight: bold; font-style:italic; color: #46C246;',
debugStyle_red = 'font-weight: bold; color: #ed1c24;',
debugStyle_warning = 'background-color:yellow',
debugStyle_success = 'background-color:green; font-weight:bold; color:#fff;',
debugStyle_error = 'background-color:#ed1c24; font-weight:bold; color:#fff;',

/*
 * Impacts the responce rate of some of the responsive elements (lower 
 * value affects CPU but improves speed)
 */
throttle_delay = 350,

/*
 * The rate at which the menu expands revealing child elements on click
 */
menu_speed = 235,
//只能同时展开一个菜单项
menu_accordion = true,

//打开 JarvisWidget 功能
enableJarvisWidgets = true,
//使用localstorage保存widget设置,如果使用onSave回调函数保存设置,该项设置为false
localStorageJarvisWidgets = true,
//是否启用JarvisWidgets的排序功能
sortableJarvisWidgets = true,
//是否启用手机组件,如果一次允许太多的组件,会有崩溃的危险,(依赖enableJarvisWidgets=true)
enableMobileWidgets = true,

//是否在移动设备上启用fastclick功能
fastClick = false,
/*
 * SMARTCHAT PLUGIN ARRAYS & CONFIG
 * Dependency: js/plugin/moment/moment.min.js 
 *             js/plugin/cssemotions/jquery.cssemoticons.min.js 
 *             js/smart-chat-ui/smart.chat.ui.js
 * (DO NOT CHANGE) 
 */
boxList = [],
showList = [],
nameList = [],
idList = [],
/*
 * Width of the chat boxes, and the gap inbetween in pixel (minus padding)
 */
chatbox_config = {
    width: 200,
    gap: 35
},
/*
 * These elements are ignored during DOM object deletion for ajax version 
 * It will delete all objects during page load with these exceptions:
 */
ignore_key_elms = ["#header, #left-panel, #right-panel, #main, div.page-footer, #shortcut, #divSmallBoxes, #divMiniIcons, #divbigBoxes, #voiceModal, script, .ui-chatbox"];
/*
 * END APP.CONFIG
 */

// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.sidebar');
goog.require('cljs.core');
goog.require('reagent.core');
goog.require('dcd_website.dcd2016');
goog.require('dcd_website.dcd2018');
goog.require('dcd_website.dcd2017');
goog.require('dcd_website.state');
goog.require('dcd_website.dcd2019');
if(typeof dcd_website.sidebar.sidebar_expanded !== 'undefined'){
} else {
dcd_website.sidebar.sidebar_expanded = reagent.core.atom.cljs$core$IFn$_invoke$arity$1(false);
}
dcd_website.sidebar.collapse_sidebar = (function dcd_website$sidebar$collapse_sidebar(){
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.sidebar.sidebar_expanded,false) : cljs.core.reset_BANG_.call(null,dcd_website.sidebar.sidebar_expanded,false));

return true;
});
dcd_website.sidebar.expand_sidebar = (function dcd_website$sidebar$expand_sidebar(){
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.sidebar.sidebar_expanded,true) : cljs.core.reset_BANG_.call(null,dcd_website.sidebar.sidebar_expanded,true));

return true;
});
dcd_website.sidebar.swap_website_structure = (function dcd_website$sidebar$swap_website_structure(new_structure){
return (cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.state.website_structure,new_structure) : cljs.core.reset_BANG_.call(null,dcd_website.state.website_structure,new_structure));
});
dcd_website.sidebar.follow_menu_link = (function dcd_website$sidebar$follow_menu_link(webcontent){
return (function (_){
dcd_website.sidebar.collapse_sidebar();

return dcd_website.sidebar.swap_website_structure(webcontent);
});
});
dcd_website.sidebar.archive = (function dcd_website$sidebar$archive(){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$span$menu_DASH_title,"Previous editions:"], null);
});
dcd_website.sidebar.menu_entry_component = (function dcd_website$sidebar$menu_entry_component(p__12816){
var map__12819 = p__12816;
var map__12819__$1 = ((((!((map__12819 == null)))?((((map__12819.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12819.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12819):map__12819);
var link = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12819__$1,cljs.core.cst$kw$link);
var text = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12819__$1,cljs.core.cst$kw$text);
var website_structure = cljs.core.get.cljs$core$IFn$_invoke$arity$3(map__12819__$1,cljs.core.cst$kw$website_DASH_structure,dcd_website.dcd2019.dcd2019_website_structure);
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$item,new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$href,link,cljs.core.cst$kw$on_DASH_click,((function (map__12819,map__12819__$1,link,text,website_structure){
return (function (){
dcd_website.sidebar.collapse_sidebar();

return dcd_website.sidebar.swap_website_structure(website_structure);
});})(map__12819,map__12819__$1,link,text,website_structure))
,cljs.core.cst$kw$key,cljs.core.gensym.cljs$core$IFn$_invoke$arity$0()], null),text], null);
});
dcd_website.sidebar.sidebar_component = (function dcd_website$sidebar$sidebar_component(){
return new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$aside$sidebar,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$class,(cljs.core.truth_((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(dcd_website.sidebar.sidebar_expanded) : cljs.core.deref.call(null,dcd_website.sidebar.sidebar_expanded)))?null:"collapsed")], null),new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a$item$expand_DASH_icon,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$on_DASH_click,(function (){
return cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.sidebar.sidebar_expanded,cljs.core.not);
})], null),"\u2630"], null),cljs.core.map.cljs$core$IFn$_invoke$arity$2(dcd_website.sidebar.menu_entry_component,new cljs.core.PersistentVector(null, 11, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#about",cljs.core.cst$kw$text,"About"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#cfp",cljs.core.cst$kw$text,"Call for papers"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#date",cljs.core.cst$kw$text,"When?"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#agenda",cljs.core.cst$kw$text,"Agenda"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#sponsors",cljs.core.cst$kw$text,"Sponsors"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#speakers",cljs.core.cst$kw$text,"Speakers"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#behave",cljs.core.cst$kw$text,"Code of conduct"], null),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$link,"#location",cljs.core.cst$kw$text,"Where?"], null),new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$link,"#dcd2018",cljs.core.cst$kw$text,"Archive: DCD2018",cljs.core.cst$kw$website_DASH_structure,dcd_website.dcd2018.dcd2018_website_structure], null),new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$link,"#dcd2017",cljs.core.cst$kw$text,"Archive: DCD2017",cljs.core.cst$kw$website_DASH_structure,dcd_website.dcd2017.dcd2017_website_structure], null),new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$link,"#dcd2016",cljs.core.cst$kw$text,"Archive: DCD2016",cljs.core.cst$kw$website_DASH_structure,dcd_website.dcd2016.dcd2016_website_structure], null)], null))], null);
});

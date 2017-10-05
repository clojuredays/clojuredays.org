// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.app');
goog.require('cljs.core');
goog.require('reagent.core');
goog.require('dcd_website.dcd2018');
goog.require('dcd_website.sidebar');
goog.require('dcd_website.map');
goog.require('dcd_website.style');
goog.require('dcd_website.state');
(cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2 ? cljs.core.reset_BANG_.cljs$core$IFn$_invoke$arity$2(dcd_website.state.website_structure,dcd_website.dcd2018.dcd2018_website_structure) : cljs.core.reset_BANG_.call(null,dcd_website.state.website_structure,dcd_website.dcd2018.dcd2018_website_structure));
dcd_website.app.website_component = (function dcd_website$app$website_component(){
var map__12849 = (cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(dcd_website.state.website_structure) : cljs.core.deref.call(null,dcd_website.state.website_structure));
var map__12849__$1 = ((((!((map__12849 == null)))?((((map__12849.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12849.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12849):map__12849);
var header_component = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12849__$1,cljs.core.cst$kw$header_DASH_component);
var main_component = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12849__$1,cljs.core.cst$kw$main_DASH_component);
var footer_component = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12849__$1,cljs.core.cst$kw$footer_DASH_component);
return new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$site,new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$wrapper,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [header_component], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.sidebar.sidebar_component], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [main_component], null)], null),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [footer_component], null)], null);
});
dcd_website.app.init = (function dcd_website$app$init(){
if(cljs.core.truth_(document.location)){
var root = document.getElementById("container");
if(cljs.core.truth_(root)){
var G__12853 = new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.app.website_component], null);
var G__12854 = root;
return (reagent.core.render_component.cljs$core$IFn$_invoke$arity$2 ? reagent.core.render_component.cljs$core$IFn$_invoke$arity$2(G__12853,G__12854) : reagent.core.render_component.call(null,G__12853,G__12854));
} else {
return null;
}
} else {
return null;
}
});
dcd_website.app.render_to_string = (function dcd_website$app$render_to_string(){
return reagent.core.render_to_string(new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [dcd_website.app.website_component], null));
});
goog.exportSymbol('dcd_website.app.render_to_string', dcd_website.app.render_to_string);

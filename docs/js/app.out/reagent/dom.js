// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('reagent.dom');
goog.require('cljs.core');
goog.require('reagent.impl.util');
goog.require('reagent.interop');
goog.require('reagent.ratom');
goog.require('reagent.impl.template');
goog.require('reagent.impl.batching');
goog.require('reagent.debug');
if(typeof reagent.dom.imported !== 'undefined'){
} else {
reagent.dom.imported = null;
}
reagent.dom.module = (function reagent$dom$module(){
if(cljs.core.some_QMARK_(reagent.dom.imported)){
return reagent.dom.imported;
} else {
if(typeof ReactDOM !== 'undefined'){
return reagent.dom.imported = ReactDOM;
} else {
if(typeof require !== 'undefined'){
var or__6457__auto__ = reagent.dom.imported = require("react-dom");
if(cljs.core.truth_(or__6457__auto__)){
return or__6457__auto__;
} else {
throw (new Error("require('react-dom') failed"));
}
} else {
throw (new Error("js/ReactDOM is missing"));

}
}
}
});
if(typeof reagent.dom.roots !== 'undefined'){
} else {
reagent.dom.roots = (function (){var G__12657 = cljs.core.PersistentArrayMap.EMPTY;
return (cljs.core.atom.cljs$core$IFn$_invoke$arity$1 ? cljs.core.atom.cljs$core$IFn$_invoke$arity$1(G__12657) : cljs.core.atom.call(null,G__12657));
})();
}
reagent.dom.unmount_comp = (function reagent$dom$unmount_comp(container){
cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$3(reagent.dom.roots,cljs.core.dissoc,container);

return (reagent.dom.module()["unmountComponentAtNode"])(container);
});
reagent.dom.render_comp = (function reagent$dom$render_comp(comp,container,callback){
var _STAR_always_update_STAR_12660 = reagent.impl.util._STAR_always_update_STAR_;
reagent.impl.util._STAR_always_update_STAR_ = true;

try{return (reagent.dom.module()["render"])((comp.cljs$core$IFn$_invoke$arity$0 ? comp.cljs$core$IFn$_invoke$arity$0() : comp.call(null)),container,((function (_STAR_always_update_STAR_12660){
return (function (){
var _STAR_always_update_STAR_12661 = reagent.impl.util._STAR_always_update_STAR_;
reagent.impl.util._STAR_always_update_STAR_ = false;

try{cljs.core.swap_BANG_.cljs$core$IFn$_invoke$arity$4(reagent.dom.roots,cljs.core.assoc,container,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [comp,container], null));

reagent.impl.batching.flush_after_render();

if(cljs.core.some_QMARK_(callback)){
return (callback.cljs$core$IFn$_invoke$arity$0 ? callback.cljs$core$IFn$_invoke$arity$0() : callback.call(null));
} else {
return null;
}
}finally {reagent.impl.util._STAR_always_update_STAR_ = _STAR_always_update_STAR_12661;
}});})(_STAR_always_update_STAR_12660))
);
}finally {reagent.impl.util._STAR_always_update_STAR_ = _STAR_always_update_STAR_12660;
}});
reagent.dom.re_render_component = (function reagent$dom$re_render_component(comp,container){
return reagent.dom.render_comp(comp,container,null);
});
/**
 * Render a Reagent component into the DOM. The first argument may be
 *   either a vector (using Reagent's Hiccup syntax), or a React element. The second argument should be a DOM node.
 * 
 *   Optionally takes a callback that is called when the component is in place.
 * 
 *   Returns the mounted component instance.
 */
reagent.dom.render = (function reagent$dom$render(var_args){
var args12662 = [];
var len__7515__auto___12665 = arguments.length;
var i__7516__auto___12666 = (0);
while(true){
if((i__7516__auto___12666 < len__7515__auto___12665)){
args12662.push((arguments[i__7516__auto___12666]));

var G__12667 = (i__7516__auto___12666 + (1));
i__7516__auto___12666 = G__12667;
continue;
} else {
}
break;
}

var G__12664 = args12662.length;
switch (G__12664) {
case 2:
return reagent.dom.render.cljs$core$IFn$_invoke$arity$2((arguments[(0)]),(arguments[(1)]));

break;
case 3:
return reagent.dom.render.cljs$core$IFn$_invoke$arity$3((arguments[(0)]),(arguments[(1)]),(arguments[(2)]));

break;
default:
throw (new Error([cljs.core.str("Invalid arity: "),cljs.core.str(args12662.length)].join('')));

}
});

reagent.dom.render.cljs$core$IFn$_invoke$arity$2 = (function (comp,container){
return reagent.dom.render.cljs$core$IFn$_invoke$arity$3(comp,container,null);
});

reagent.dom.render.cljs$core$IFn$_invoke$arity$3 = (function (comp,container,callback){
reagent.ratom.flush_BANG_();

var f = (function (){
return reagent.impl.template.as_element(((cljs.core.fn_QMARK_(comp))?(comp.cljs$core$IFn$_invoke$arity$0 ? comp.cljs$core$IFn$_invoke$arity$0() : comp.call(null)):comp));
});
return reagent.dom.render_comp(f,container,callback);
});

reagent.dom.render.cljs$lang$maxFixedArity = 3;
reagent.dom.unmount_component_at_node = (function reagent$dom$unmount_component_at_node(container){
return reagent.dom.unmount_comp(container);
});
/**
 * Returns the root DOM node of a mounted component.
 */
reagent.dom.dom_node = (function reagent$dom$dom_node(this$){
return (reagent.dom.module()["findDOMNode"])(this$);
});
/**
 * Force re-rendering of all mounted Reagent components. This is
 *   probably only useful in a development environment, when you want to
 *   update components in response to some dynamic changes to code.
 * 
 *   Note that force-update-all may not update root components. This
 *   happens if a component 'foo' is mounted with `(render [foo])` (since
 *   functions are passed by value, and not by reference, in
 *   ClojureScript). To get around this you'll have to introduce a layer
 *   of indirection, for example by using `(render [#'foo])` instead.
 */
reagent.dom.force_update_all = (function reagent$dom$force_update_all(){
reagent.ratom.flush_BANG_();

var seq__12673_12677 = cljs.core.seq(cljs.core.vals((cljs.core.deref.cljs$core$IFn$_invoke$arity$1 ? cljs.core.deref.cljs$core$IFn$_invoke$arity$1(reagent.dom.roots) : cljs.core.deref.call(null,reagent.dom.roots))));
var chunk__12674_12678 = null;
var count__12675_12679 = (0);
var i__12676_12680 = (0);
while(true){
if((i__12676_12680 < count__12675_12679)){
var v_12681 = chunk__12674_12678.cljs$core$IIndexed$_nth$arity$2(null,i__12676_12680);
cljs.core.apply.cljs$core$IFn$_invoke$arity$2(reagent.dom.re_render_component,v_12681);

var G__12682 = seq__12673_12677;
var G__12683 = chunk__12674_12678;
var G__12684 = count__12675_12679;
var G__12685 = (i__12676_12680 + (1));
seq__12673_12677 = G__12682;
chunk__12674_12678 = G__12683;
count__12675_12679 = G__12684;
i__12676_12680 = G__12685;
continue;
} else {
var temp__4657__auto___12686 = cljs.core.seq(seq__12673_12677);
if(temp__4657__auto___12686){
var seq__12673_12687__$1 = temp__4657__auto___12686;
if(cljs.core.chunked_seq_QMARK_(seq__12673_12687__$1)){
var c__7260__auto___12688 = cljs.core.chunk_first(seq__12673_12687__$1);
var G__12689 = cljs.core.chunk_rest(seq__12673_12687__$1);
var G__12690 = c__7260__auto___12688;
var G__12691 = cljs.core.count(c__7260__auto___12688);
var G__12692 = (0);
seq__12673_12677 = G__12689;
chunk__12674_12678 = G__12690;
count__12675_12679 = G__12691;
i__12676_12680 = G__12692;
continue;
} else {
var v_12693 = cljs.core.first(seq__12673_12687__$1);
cljs.core.apply.cljs$core$IFn$_invoke$arity$2(reagent.dom.re_render_component,v_12693);

var G__12694 = cljs.core.next(seq__12673_12687__$1);
var G__12695 = null;
var G__12696 = (0);
var G__12697 = (0);
seq__12673_12677 = G__12694;
chunk__12674_12678 = G__12695;
count__12675_12679 = G__12696;
i__12676_12680 = G__12697;
continue;
}
} else {
}
}
break;
}

return "Updated";
});

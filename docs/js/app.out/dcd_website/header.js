// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.header');
goog.require('cljs.core');
dcd_website.header.header_component = (function dcd_website$header$header_component(var_args){
var args__7522__auto__ = [];
var len__7515__auto___12634 = arguments.length;
var i__7516__auto___12635 = (0);
while(true){
if((i__7516__auto___12635 < len__7515__auto___12634)){
args__7522__auto__.push((arguments[i__7516__auto___12635]));

var G__12636 = (i__7516__auto___12635 + (1));
i__7516__auto___12635 = G__12636;
continue;
} else {
}
break;
}

var argseq__7523__auto__ = ((((1) < args__7522__auto__.length))?(new cljs.core.IndexedSeq(args__7522__auto__.slice((1)),(0))):null);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic((arguments[(0)]),argseq__7523__auto__);
});

dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic = (function (p__12631,children){
var map__12632 = p__12631;
var map__12632__$1 = ((((!((map__12632 == null)))?((((map__12632.cljs$lang$protocol_mask$partition0$ & (64))) || (map__12632.cljs$core$ISeq$))?true:false):false))?cljs.core.apply.cljs$core$IFn$_invoke$arity$2(cljs.core.hash_map,map__12632):map__12632);
var styles = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12632__$1,cljs.core.cst$kw$styles);
var title = cljs.core.get.cljs$core$IFn$_invoke$arity$2(map__12632__$1,cljs.core.cst$kw$title);
return new cljs.core.PersistentVector(null, 5, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$header$header,styles,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div$logo,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$img,new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$src,"/img/2019/logo.svg"], null)], null)], null),new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$span$title,"DUTCH CLOJURE DAYS 2019"], null),children], null);
});

dcd_website.header.header_component.cljs$lang$maxFixedArity = (1);

dcd_website.header.header_component.cljs$lang$applyTo = (function (seq12629){
var G__12630 = cljs.core.first(seq12629);
var seq12629__$1 = cljs.core.next(seq12629);
return dcd_website.header.header_component.cljs$core$IFn$_invoke$arity$variadic(G__12630,seq12629__$1);
});

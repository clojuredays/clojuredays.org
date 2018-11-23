// Compiled by ClojureScript 1.7.228 {:static-fns true, :optimize-constants true}
goog.provide('dcd_website.dcd2016');
goog.require('cljs.core');
goog.require('dcd_website.header');
goog.require('dcd_website.footer');
dcd_website.dcd2016.header_component_2016 = (function dcd_website$dcd2016$header_component_2016(){
return dcd_website.header.header_component(new cljs.core.PersistentArrayMap(null, 1, [cljs.core.cst$kw$title,"Dutch Clojure Days 2016"], null));
});
dcd_website.dcd2016.main_component = (function dcd_website$dcd2016$main_component(){
return new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$article$main,new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$div_SHARP_dcd16,new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$h2,"DCD16"], null),new cljs.core.PersistentVector(null, 4, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$p,"Videos from the previous event are available here: ",new cljs.core.PersistentVector(null, 3, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$a,new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$href,"https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD",cljs.core.cst$kw$target,cljs.core.cst$kw$_blank], null),"DCD16 Playlist on Youtube"], null),"."], null)], null)], null);
});
dcd_website.dcd2016.dcd2016_website_structure = new cljs.core.PersistentArrayMap(null, 3, [cljs.core.cst$kw$header_DASH_component,dcd_website.dcd2016.header_component_2016,cljs.core.cst$kw$main_DASH_component,dcd_website.dcd2016.main_component,cljs.core.cst$kw$footer_DASH_component,dcd_website.footer.footer_component], null);

(ns novel-browser.view.top
  (:require [re-frame.core :as re]
            [novel-browser.view.layouts :as layouts]
            [novel-browser.sub.api :as api-sub]))

(defn panel []
  [:div#top.page
   [layouts/header]
   (let [favorites @(re/subscribe [::api-sub/favorites])]
     (str favorites))])

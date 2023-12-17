(ns novel-browser.api
  (:require [lambdaisland.fetch :as fetch]
            [re-frame.core :as re-frame]
            [shadow.cljs.modern :refer [js-await]]
            [novel-browser.event.api :as event]))

(defn get-favotites []
  (js-await [res (fetch/get "http://localhost:13000/novel/favorites"
                            {:accept :json
                             :content-type :json})]
    (re-frame/dispatch-sync [::event/favorites (-> res :body js->clj)])))

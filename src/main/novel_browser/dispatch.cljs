(ns novel-browser.dispatch
  (:require [re-frame.core :as re-frame]
            [novel-browser.api :as api]
            [novel-browser.event.core :as event]))

(defmulti dispatch-sync (fn [key _] key))

(defmethod dispatch-sync :top
  [_ _]
  (re-frame/dispatch-sync [::event/set-active-panel :top])
  (api/get-favotites))

(defmethod dispatch-sync :init
  [_ _]
  (re-frame/dispatch-sync [::event/initialize-db]))

(defn dispatch
  ([key] (dispatch key nil))
  ([key value] (dispatch-sync key value)))

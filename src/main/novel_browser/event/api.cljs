(ns novel-browser.event.api
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
  ::favorites
  (fn [db [_ body]]
    (assoc-in db [:api :favorites] body)))

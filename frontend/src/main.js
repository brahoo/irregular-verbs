import Vue from 'vue';
import App from './App.vue';
import VueResource from "vue-resource";

Vue.use(VueResource)
Vue.http.options.root = '/api';

//turn it later to false
Vue.config.productionTip = true

new Vue({
  render: h => h(App),
}).$mount('#app')

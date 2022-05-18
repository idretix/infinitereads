<template>
  <v-form
    ref="form"
    class="ml-6 mr-6"
  >
       <div class="font-italic">
    <h1>Login</h1>
  </div>
    <v-text-field
      v-model="username"
      label="Userame"
      required
    ></v-text-field>

    <v-text-field
      v-model="password"
      label="Password"
      type="password"
      required
    ></v-text-field>

    <v-btn
      color="success"
      class="mr-4"
      @click="login"
    >
      Login
    </v-btn>

    <v-btn
      color="error"
      class="mr-4"
      @click="$router.push({ name: 'register' })"
    >
      Register
    </v-btn>
  </v-form>
</template>

<script>
/* eslint-disable no-unused-vars */

  import axios from "axios";
  export default {
    name: 'LoginView',
    data() {
      return {
        username: "",
        password: ""
      }
    },
    methods: {
       async login() {
         try { 
           var result = await axios.get("http://localhost:8080/api/v1/user/"+this.username+"/"+this.password);
           window.localStorage.setItem("userId", result.data.id);
           window.localStorage.setItem("username",result.data.username);
        //   window.localStorage.setItem("username", result.data.username);
           window.localStorage.setItem("admin", result.data.admin);
           console.log(window.localStorage.getItem("admin"))
          if(window.localStorage.getItem("admin")==="true")
           this.$router.push({ name: 'managebook' });
          else     
                 this.$router.push({ name: 'hello' });

         } catch (e) {
           alert("Credentiale incorecte!");
         }
       }
    }
  }
  /* eslint-enable no-unused-vars */

</script>

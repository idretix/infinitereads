<template>
  <v-form
    ref="form"
    class="ml-6 mr-6"
  >
    <v-text-field
      v-model="username"
      label="Username"
      required
    >
    </v-text-field>

    <v-text-field
      v-model="password"
      label="Password"
      type="password"
      required
    >
    </v-text-field>

    <v-text-field
      v-model="type"
      label="Type"
      readonly
      required
    >
    </v-text-field>

     <v-btn
      class="mr-4"
      color="success"
      @click="update"
    >
      <v-icon left>
        mdi-account-edit
      </v-icon>
      Update
    </v-btn>

    <v-btn
      color="error"
      class="mr-4"
      @click="del"
    >
      <v-icon left>
          mdi-account-remove
      </v-icon>
      Delete
    </v-btn>

    <v-btn
      color="warning"
      class="mr-4"
      @click="$router.push({ name: 'login' })"
    >
      <v-icon left>
          mdi-arrow-left
      </v-icon>
      Log Out
    </v-btn>

    <br><br><br>
    All users:
    <br><br>
    <ul id="all-users">

      <li v-for="item in allUsers" :key="item.iduser">

        username: {{ item.username }} <br> password: {{ item.password }}

      </li>

    </ul>

  </v-form>
</template>

<script>
  import axios from "axios";
  export default {
    name: 'home',
    data() {
      return {
        loggedInUser: null,
        username: "",
        password: "",
        type: "",
        allUsers: [],
      }
    },
    async created() {
      try {
        var resultUsers = await axios.get("http://localhost:8080/api/usertable");
        var result = await axios.get("http://localhost:8080/api/usertable/" + window.localStorage.getItem("idUser"));
        this.loggedInUser = result.data;
        this.username = this.loggedInUser.username;
        this.password = this.loggedInUser.password;
        this.allUsers = resultUsers.data;
        if (this.loggedInUser.type == 0)
          this.type = "Student";
        else
          this.type = "Teacher";
      }
      catch (e) {
        alert("Error loading your personal information!");
      }
    },
     methods: {
      async del(){
        try { 
          var result = await axios.delete("http://localhost:8080/api/usertable/" + window.localStorage.getItem("idUser"));
          this.$router.push({ name: 'login' });
          alert("Your account was deleted!");
          
        } catch (e) {
          alert("Failed to delete your account!");
        }
      },
      async update() {
        try { 
          if (this.username == "" || this.password == "") {
            throw error;
          }
          else {
            var result = await axios.put("http://localhost:8080/api/usertable/" + window.localStorage.getItem("idUser"), { type: this.loggedInUser.type, username: this.username, password: this.password });
            alert("Personal information updated!");
          }
        } catch (e) {
          alert("Error updating your personal information! All fields are mandatory!\n");
        }
      }
    }
  }
  
</script>
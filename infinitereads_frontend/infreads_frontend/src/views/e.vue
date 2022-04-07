<template>
  <v-form ref="form" class="ml-6 mr-6">
    <v-text-field v-model="id" label="User Id" required></v-text-field>

    <v-text-field v-model="name" label="User Name" required></v-text-field>

    <v-text-field v-model="password" label="Password" required></v-text-field>

    <v-text-field v-model="role" label="User Role" required></v-text-field>

    <v-btn color="success" class="mr-4" @click="findAllUsers">
      Find All Users
    </v-btn>

    <v-btn color="success" class="mr-4" @click="editUser"> Edit User </v-btn>

    <v-btn color="error" class="mr-4"> Delete User </v-btn>

    <v-simple-table dense>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">User Name</th>
            <th class="text-left">User Password</th>
            <th class="text-left">User Is Admin</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in users" :key="item.user_id">
            <td>{{ item.user_id }}</td>
            <td>{{ item.user_name }}</td>
            <td>{{ item.user_password }}</td>
            <td>{{ item.user_isAdmin }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-form>
</template>

<script>
import axios from "axios";
export default {
  name: 'AdminPanel',  
  data() {
    return {
      id: "",
      name: "",
      password: "",
      role: "",
      users: [],
    };
  },
  methods: {
    async findAllUsers() {
      try {
          var users = await axios.get("http://localhost:8080/api/users");
          this.users = users.data.sort(function(a, b) {
            return parseFloat(a.user_id) - parseFloat(b.user_id);
            });;
          window.localStorage.setItem("id", users.data.id);
      } catch (e) {
          alert("Eroare");
      }
    },
    async editUser() {
      try {
          var users = await axios.put("http://localhost:8080/api/users/"+this.id, {
            user_id: this.id,
            user_name: this.name,
            user_password: this.password,
            user_isAdmin: this.role,
          });
        window.localStorage.setItem("id", users.data.id);
      } catch (e) {
          alert("Eroare");
      }
    },
  },
};
</script>
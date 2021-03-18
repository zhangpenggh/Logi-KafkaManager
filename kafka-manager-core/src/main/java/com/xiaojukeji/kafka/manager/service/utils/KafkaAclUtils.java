package com.xiaojukeji.kafka.manager.service.utils;

import kafka.admin.AclCommand;
import kafka.admin.ConfigCommand;

public class KafkaAclUtils {

    public static void assignConsumerByGroup(String zookeeper, String user, String group, String topic) throws Exception {
        String[] args = new String[]{
                "--authorizer-properties",
                "zookeeper.connect=" + zookeeper,
                "--add",
                "--allow-principal",
                "User:" + user,
                "--consumer",
                "--group='"+ group + "'",
                "--topic",
                topic
        };
        AclCommand.main(args);
    }

    public static void assignConsumerByGroupPrefix(String zookeeper, String user, String group, String topic) throws Exception {
        String[] args = new String[]{
                "--authorizer-properties",
                "zookeeper.connect=" + zookeeper,
                "--add",
                "--allow-principal",
                "User:"+ user,
                "--consumer",
                "--group='" + group + "'",
                "--resource-pattern-type",
                "prefixed",
                "--topic",
                "crm_db_log"
        };
        AclCommand.main(args);
    }

    public static void assignProducer(String zookeeper, String user, String topic) {

        String[] args = new String[] {
                "--authorizer-properties",
                "zookeeper.connect=" + zookeeper,
                "--add",
                "--allow-principal",
                "User:" + user,
                "--producer",
                "--topic",
                topic
        };
        AclCommand.main(args);
    }

    public static void createUser(String zookeeper, String user, String password) {
        String[] args = new String[] {
                "--zookeeper",
                zookeeper,
                "--alter",
                "--add-config",
                "SCRAM-SHA-256=[password=" + password + "],SCRAM-SHA-512=[password=" + password + "]",
                "--entity-type",
                "users",
                "--entity-name",
                user
        };
        ConfigCommand.main(args);
    }
}

package com.xiaojukeji.kafka.manager.service.utils;

import kafka.admin.AclCommand;
import kafka.admin.ConfigCommand;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaAclUtils {
    private static final Logger logger = LoggerFactory.getLogger(KafkaAclUtils.class);

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
        logger.info("消费组授权：" + StringUtils.join(args, " "));
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
                topic
        };

        logger.info("消费组前缀授权：" + StringUtils.join(args, " "));
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
        logger.info("生产者授权：" + StringUtils.join(args, " "));
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

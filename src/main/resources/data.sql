
-- fill roles table

INSERT INTO app_role (id, role_name, description) VALUES (1, 'USER', 'Standard User - the system client (public)')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN', 'Admin User - Has permission to perform all tasks')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (3, 'DISPATCHER', 'DISPATCHER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (4, 'CONTROLLER', 'CONTROLLER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (5, 'DELIVERYMAN', 'DELIVERYMAN')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (6, 'OPERATOR', 'OPERATOR')
ON CONFLICT (id) DO NOTHING;


-- temp
/*
INSERT INTO app_user (id, first_name, last_name, password, username)
VALUES (2, 'John', 'Doe', 'd9fbdcbab0d28ac189307c30b68c3efaee39e16663c7438ae186d5b6566b7396', 'admin')
ON CONFLICT (id) DO NOTHING;*/
